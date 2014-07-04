var pgDb = require('../db')
  , db

var user = {
    setDb: setDb
  , getById: getById
}

module.exports = user

function setDb(_db) {
  db = _db || pgDb
}

function getById(id, ready) {
  var testUsers = [
      {username: 'derp', email: 'herp@derp.gov', realName: 'Herp Derper'}
    , {username: 'larp', email: 'big@larpfan.com', realName: 'Harvey'}
    , {username: 'frog', email: 'toad@turtle.net', realName: 'Owl Bear'}
  ]

  ready(null, testUsers[+id])
}
