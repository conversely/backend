var send = require('http-json-response')

var userModel = require('../models/user')
  , errors = require('../errors')

var userController = {
    get: getUser
  , create: createUser
  , remove: removeUser
  , update: updateUser
}

module.exports = userController

function getUser(req, res, route) {
  if(route.query.id) {
    return userModel.getById(route.query.id, respond)
  }

  errors.notFound(req, res)

  function respond(err, data) {
    if(err) return errors.internal(req, res)
    if(!data) return errors.notFound(req, res)

    send(res, 200, data)
  }
}

function createUser() {
}

function removeUser() {
}

function updateUser() {
}
