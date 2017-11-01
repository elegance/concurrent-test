let http = require('http');
let hostName = '127.0.0.1';
let port = 3000;

const server = http.createServer((req, res) => {
    res.end('hello');
});

server.listen(port, hostName, () => {
    console.log(`server running at http://${hostName}:${port}`)
});
