(ns conversely.db.core
  (:use korma.core)
  (:require [korma.db :refer [defdb]]
            [conversely.db.schema :as schema]))

(defdb db schema/db-spec)

(declare users)

(defentity emails
  (belongs-to users))

(defentity handles
  (belongs-to users))

(defentity roles
  (belongs-to users))

(defentity users
  (has-many emails)
  (has-many handles)
  (has-many roles))

(defn get-user [id]
  (first (select users
                 (with emails)
                 (with handles)
                 (with roles)
                 (where {:id id})
                 (limit 1))))
