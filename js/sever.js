const express = require('express');
const app = express();
const path = require('path');
const WEBPATH = path.join(__dirname, '../front');
const PORT = 3000;
const bodyParser = require('body-parser');
const mysql = require('mysql');

app.use(express.static(WEBPATH));
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// MySQL 데이터베이스 연결 설정
const connection = mysql.createConnection({
  host: 'localhost',
  port: '3306',
  user: 'root',
  password: 'dbswlstn1',
  database: 'mysql',
  charset: 'utf8mb4', // 인코딩 설정 추가
});

// 데이터베이스 연결
connection.connect((err) => {
  if (err) {
    console.error('Failed to connect to database:', err);
    return;
  }
  console.log('Connected to the database');
});

app.get('/', (req, res) => {
  res.sendFile(`${WEBPATH}/main.html`);
});

// main 페이지 요청 핸들러
function renderMainPage(req, res) {
  // 페이지 번호 및 한 페이지에 표시할 게시물 수 설정
  const page = req.query.page || 1;
  const pageSize = 5;

  const currentPage = parseInt(page);
  // 게시물 조회 쿼리
  const query = `
    SELECT *
    FROM post
    ORDER BY num DESC
    LIMIT ${(page - 1) * pageSize}, ${pageSize};
  `;

  // 게시물 개수 조회 쿼리
  const countQuery = 'SELECT COUNT(*) AS totalCount FROM post;';

  // 게시물 데이터 가져오기
  connection.query(query, (error, results) => {
    if (error) {
      console.error('Error fetching posts:', error);
      res.status(500).send('Error fetching posts');
    } else {
      const posts = results;

      // 전체 게시물 개수 조회
      connection.query(countQuery, (error, countResults) => {
        if (error) {
          console.error('Error fetching total post count:', error);
          res.status(500).send('Error fetching total post count');
        } else {
          const totalCount = countResults[0].totalCount;

          // 전체 페이지 수 계산
          const totalPages = Math.ceil(totalCount / pageSize);

          // 현재 페이지 번호 설정
          const currentPage = parseInt(page);

          // HTML 템플릿
          const html = `
            <!DOCTYPE html>
            <html lang="ko">
              <head>
                <meta charset="UTF-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <title>DB_WEB</title>
                <link rel="stylesheet" href="css/css.css" />
              </head>
              <body>
                <div class="db_web_wrap">
                  <div class="db_web_title">
                    <strong>DB_WEB 게시판</strong>
                    <p>바르고 고운말을 사용하도록 합시다.</p>
                  </div>
                  <div class="db_web_main_wrap">
                    <div class="db_web_main">
                      <div class="top">
                        <div class="num">번호</div>
                        <div class="title">제목</div>
                        <div class="writer">글쓴이</div>
                        <div class="w_date">작성일</div>
                        <div class="r_count">조회</div>
                      </div>
                      <div id="postsContainer">
                        <!-- Posts will be dynamically added here using JavaScript -->
                      </div>
                    </div>
                    <div class="db_web_page" id="pageLinksContainer">
                      <!-- Page links will be dynamically added here using JavaScript -->
                    </div>
                    <div class="bt_wrap">
                      <a href="write.html" class="on">등록</a>
                      <!--<a href="#">수정</a>-->
                    </div>
                  </div>
                </div>
              </body>
              <script>
                // 게시물 데이터
                const posts = ${JSON.stringify(posts)};

                // 전체 페이지 수
                const totalPages = ${totalPages};

                // 현재 페이지 번호
                const currentPage = ${currentPage};

                // 게시물 컨테이너
                const postsContainer = document.getElementById('postsContainer');

                // 페이지 링크 컨테이너
                const pageLinksContainer = document.getElementById('pageLinksContainer');

                // 게시물 데이터 동적으로 생성
                posts.forEach((post) => {
                  const postElement = document.createElement('div');
                  postElement.innerHTML = \`
                    <div>
                      <div class="num">${posts.num}</div>
                      <div class="title">
                        <a href="view">${posts.title}</a>
                        <div class="c_count">
                          <a href="#">[${posts.c_count}]</a>
                        </div>
                      </div>
                      <div class="writer">${posts.writer}</div>
                      <div class="w_date">${posts.w_date}</div>
                      <div class="r_count">${posts.r_count}</div>
                    </div>
                  \`;
                  postsContainer.appendChild(postElement);
                });

                // 페이지 링크 동적으로 생성
                for (let i = 1; i <= totalPages; i++) {
                  const pageLink = document.createElement('a');
                  pageLink.href = \`/main?page=\${i}\`;
                  pageLink.textContent = i;
                  if (i === currentPage) {
                    pageLink.classList.add('current');
                  }
                  pageLinksContainer.appendChild(pageLink);
                }
              </script>
            </html>
          `;

          // 응답 보내기
          res.send(html);
        }
      });
    }
  });
}

app.get('/main/posts', (req, res) => {
  // 페이지 번호 및 한 페이지에 표시할 게시물 수 설정
  const page = req.query.page || 1;
  const pageSize = 5;

  // 게시물 조회 쿼리
  const query = `
    SELECT num, title, writer, w_date, r_count
    FROM post
    ORDER BY num DESC
    LIMIT ${(page - 1) * pageSize}, ${pageSize};
  `;

  // 게시물 데이터 가져오기
  connection.query(query, (error, results) => {
    if (error) {
      console.error('Error fetching posts:', error);
      res.status(500).json({ error: 'Error fetching posts' });
    } else {
      const posts = results;

      res.json(posts);
    }
  });
});

// main 페이지 요청 핸들러
app.get('/main', renderMainPage);

// 게시글 작성 처리
app.post('/create-post', (req, res) => {
  const { title, contents, writer } = req.body;
  const currentDate = new Date();
  const year = currentDate.getFullYear();
  const month = String(currentDate.getMonth() + 1).padStart(2, '0');
  const day = String(currentDate.getDate()).padStart(2, '0');
  const formattedDate = `${year}-${month}-${day}`;

  const query =
    'INSERT INTO post (title, contents, writer, w_date) VALUES (?, ?, ?, ?)';
  connection.query(
    query,
    [title, contents, writer, new Date(formattedDate)],
    (err, result) => {
      if (err) {
        console.error('Failed to insert post:', err);
        res.status(500).send('Failed to create a post');
        return;
      }

      console.log('Post created successfully');
      res.redirect('/main.html');
    },
  );
});
app.get('/main/view/:num', (req, res) => {
  // 게시글 조회를 위한 로직 구현
  const num = req.params.num; // 주소에서 게시글 번호 가져오기

  // num을 기반으로 데이터베이스에서 게시글 조회
  // 예시로 데이터베이스에서 게시글을 가져오는 비동기 함수를 가정합니다.
  getPostFromDatabase(num)
    .then((post) => {
      // 게시글을 정상적으로 가져온 경우
      const dynamicHtml = `
        <!DOCTYPE html>
        <html lang="ko">
          <head>
            <meta charset="UTF-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>DB_WEB - 글 보기</title>
            <link rel="stylesheet" href="/css/css.css" />
          </head>
          <body>
            <div class="db_web_wrap">
              <div class="db_web_title">
                <strong>DB_WEB 게시판</strong>
                <p>바르고 고운말을 사용하도록 합시다.</p>
              </div>
              <div class="db_web_view_wrap">
                <div class="db_web_view">
                  <div class="title">${post.title}</div>
                  <div class="info">
                    <dl>
                      <dt>번호</dt>
                      <dd>${post.num}</dd>
                    </dl>
                    <dl>
                      <dt>글쓴이</dt>
                      <dd>${post.writer}</dd>
                    </dl>
                    <dl>
                      <dt>작성일</dt>
                      <dd>${post.w_date}</dd>
                    </dl>
                    <dl>
                      <dt>조회</dt>
                      <dd>${post.r_count}</dd>
                    </dl>
                  </div>
                  <div class="cont">${post.contents}</div>
                </div>
                <div class="bt_wrap">
                  <a href="/main" class="on">목록</a>
                  <a href="/main/edit/${post.num}">수정</a>
                </div>
              </div>
            </div>
          </body>
        </html>
      `;
      res.send(dynamicHtml);
      // 게시글 조회 중에 조회수 업데이트
      const updateQuery = `
        UPDATE post
        SET r_count = r_count + 1
        WHERE num = ${num};
      `;
      connection.query(updateQuery, (error) => {
        if (error) {
          console.error('Error updating post count:', error);
        }
      });
    })
    .catch((error) => {
      // 게시글 조회 중 에러 발생한 경우
      console.error('Error fetching post:', error);
      res.status(500).send('Error fetching post');
    });
});
function getPostFromDatabase(num) {
  return new Promise((resolve, reject) => {
    const query = `SELECT * FROM post WHERE num = ${num};`;
    connection.query(query, (error, results) => {
      if (error) {
        reject(error);
      } else {
        if (results.length > 0) {
          resolve(results[0]);
        } else {
          reject(new Error('Post not found'));
        }
      }
    });
  });
}

app.get('/main/edit/:num', (req, res) => {
  const num = req.params.num; // 요청에서 게시글 번호 가져오기

  // 게시글 조회를 위한 로직 구현
  // 예를 들어, 데이터베이스에서 게시글을 가져오는 비동기 함수를 가정합니다.
  getPostFromDatabase(num)
    .then((post) => {
      // 게시글을 정상적으로 가져온 경우
      // 게시글 수정을 위한 HTML 페이지를 응답으로 보냅니다.
      const dynamicHtml = `
      <!DOCTYPE html>
      <html lang="ko">
        <head>
          <meta charset="UTF-8" />
          <meta http-equiv="X-UA-Compatible" content="IE=edge" />
          <meta name="viewport" content="width=device-width, initial-scale=1.0" />
          <title>DB_WEB</title>
          <link rel="stylesheet" href="css/css.css" />
        </head>
        <body>
          <div class="db_web_wrap">
            <div class="db_web_title">
              <strong>DB_WEB 게시판</strong>
              <p>바르고 고운말을 사용하도록 합시다.</p>
            </div>
            <div class="db_web_write_wrap">
              <div class="db_web_write">
                <div class="title">
                  <dl>
                    <dt>제목</dt>
                    <dd>
                      <input type="text" id="titleInput" placeholder="제목 입력" />
                    </dd>
                  </dl>
                </div>
                <div class="info">
                  <dl>
                    <dt>글쓴이</dt>
                    <dd>
                      <input type="text" id="authorInput" placeholder="글쓴이 입력" />
                    </dd>
                  </dl>
                </div>
                <div class="cont">
                  <textarea id="contentInput" placeholder="내용 입력"></textarea>
                </div>
              </div>
              <div class="bt_wrap">
                <button type="button" onclick="updatePost()">수정</button>
                <a href="view.html">취소</a>
              </div>
            </div>
          </div>
      
          <script>
            // 서버로부터 게시글 데이터 동적으로 가져오기
            const num = 1; // 서버나 URL에서 num 값을 가져오는 로직 작성
      
            fetch(/getPost/${num})
              .then(response => response.json())
              .then(data => {
                if (data.success) {
                  const post = data.post;
      
                  // 입력 필드에 게시글 데이터 채우기
                  document.getElementById('titleInput').value = post.title;
                  document.getElementById('authorInput').value = post.author;
                  document.getElementById('contentInput').value = post.content;
                } else {
                  console.error('게시글을 가져오는 중 오류 발생:', data.error);
                }
              })
              .catch(error => {
                console.error('게시글을 가져오는 중 오류 발생:', error);
              });
      
            // 게시글 수정 함수
            function updatePost() {
              // 입력 필드에서 업데이트된 값 가져오기
              const title = document.getElementById('titleInput').value;
              const author = document.getElementById('authorInput').value;
              const content = document.getElementById('contentInput').value;
      
              // 서버로 전송할 데이터 구성
              const data = {
                num: num,
                title: title,
                author: author,
                content: content,
              };
      
              // 수정된 게시글 데이터 서버로 전송
              fetch('/update', {
                method: 'POST',
                headers: {
                  'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
              })
                .then(response => response.json())
                .then(result => {
                  if (result.success) {
                    // 게시글 수정이 성공한 경우 처리
                    console.log('게시글이 성공적으로 업데이트되었습니다.');
                    // view.html로 리디렉션 또는 원하는 동작 수행
                  } else {
                    // 게시글 수정 중 오류 발생한 경우 처리
                    console.error('게시글 업데이트 오류:', result.error);
                  }
                })
                .catch(error => {
                  console.error('게시글 업데이트 중 오류 발생:', error);
                });
            }
          </script>
        </body>
      </html>
      `;
      res.send(dynamicHtml);
    })
    .catch((error) => {
      console.error('Error fetching post:', error);
      res.status(500).send('Error fetching post');
    });
});
// 게시글 수정 API
app.post('/update', (req, res) => {
  const { num, title, author, content } = req.body;

  // 게시글 수정 쿼리
  const query = `
    UPDATE post
    SET title = ?, author = ?, content = ?
    WHERE num = ?;
  `;

  // 게시글 수정
  connection.query(query, [title, author, content, num], (error, results) => {
    if (error) {
      console.error('Failed to update post:', error);
      res.status(500).json({ success: false, error: 'Failed to update post' });
    } else {
      console.log('Post updated successfully');
      res.json({ success: true });
    }
  });
});
// 서버 실행
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
