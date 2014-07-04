var http = require('http')

var routes = require('./lib/routes')
  , errors = require('./lib/errors')
  , db = require('./lib/db')

module.exports = setup

function setup(dbLocation) {
  db(dbLocation)

  return http.createServer(handler)

  function handler(req, res) {
    var route = routes.match(req)

    if(route) return route.fn(req, res, route)

    errors.notFound(req, res)
  }
}
