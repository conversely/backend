var pgDb = require('../db')
  , db

module.exports = user

function user(_db) {
  db = _db || pgDb()

  var user = {
      getById: getById
  }

  return user
}

function getById(id, ready) {
  ready(null, null)
}
