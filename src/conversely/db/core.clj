(ns conversely.db.core
  (:use korma.core)
  (:require [korma.db :refer [defdb]]
            [conversely.db.schema :as schema]))

(defdb db schema/db-spec)

(declare users)

(defn get-user [id]
  (first (select users
                 (where {:id id})
                 (limit 1))))
