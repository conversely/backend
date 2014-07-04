var Router = require('unpm-router')

var userRoutes = require('./users')

var router = Router()

userRoutes(router)

module.exports = router
