var POSTGRES_URI = process.env.CONVERSELY_DB ||
    'postgres://derp:derp@localhost/conversely'
var PORT = process.argv[2] || process.env.CONVERSELY_PORT || 8876

var server = require('../')()

server.listen(PORT)
