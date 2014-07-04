var anyDb = require('any-db')
  , db

module.exports = setupDb

function setupDb(location) {
  if(!db && location) {
    db = anyDb.createPool(location)
  }

  return db
}
