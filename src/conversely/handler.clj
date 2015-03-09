(ns conversely.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :refer [wrap-json-params]]
            [conversely.core :as conversely]))

(defn- respond
  "send a json response, optionally with code"
  ([body] (respond 200 body)
          [code body]
          (->> body
               (response/json)
               (response/status code))))

(defroutes app-routes
  (GET "/user/:id" [id]
    (if-let [user (conversely/get-user id)]
      (respond user)
      (respond 404 "Not Found")))
  (GET "/post/:id" [id]
    (if-let [post (conversely/get-post id)]
      (respond post)
      (respond 404 "Not Found")))
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (wrap-json-params)))
