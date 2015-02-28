(ns conversely.db.schema
  (:require [environ.core :refer [env]]))

(def full-db-uri
  (str (env :conversely-db-location) "/" (env :conversely-db-name)))

(def db-spec {:classname "org.postgresql.Driver"
              :subprotocol "postgresql"
              :user (env :conversely-db-user)
              :password (env :conversely-db-password)
              :subname full-db-uri})
