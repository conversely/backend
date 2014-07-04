var userController = require('../controllers/user')

module.exports = userRoutes

function userRoutes(router) {
  router.add('get', '/user', userController.get)
  router.add('post', '/user', userController.create)
  router.add('put', '/user/:id', userController.update)
  router.add('delete', '/user/:id', userController.remove)
}
