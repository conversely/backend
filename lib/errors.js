var errors = {
    notFound: makeError(404, 'Not found')
  , internal: makeError(500, 'Internal Server Error')
  , unauthorized: makeError(401, 'Unauthorized')
  , forbidden: makeError(403, 'Forbidden')
}

module.exports = errors

function makeError(code, message) {
  return function errorResponse(req, res) {
    res.writeHead(code, {'content-type': 'text/plain'})
    res.end(message)
  }
}
