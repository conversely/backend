(ns conversely.db.core
  (:use korma.core)
  (:require [korma.db :refer [defdb]]
            [conversely.db.schema :as schema]))

(defdb db schema/db-spec)

(declare users emails handles roles posts comments)

(defentity users
  (has-many emails)
  (has-many handles)
  (many-to-many roles :users_roles))

(defentity posts
  (belongs-to users))

(defentity comments
  (belongs-to users)
  (belongs-to posts))

(defentity emails
  (belongs-to users))

(defentity handles
  (belongs-to users))

(defentity roles
  (many-to-many users :users_roles))

(defn- insert! [table-name row-data]
  (insert table-name
          (values row-data)))

(defn get-user [id]
  (first (select users
                 (with emails)
                 (with handles)
                 (with roles)
                 (where {:id id})
                 (limit 1))))

(defn add-user! [user-data]
  (insert! users user-data))

(defn get-post [id]
  (first (select posts
                 (with users)
                 (with comments)
                 (where {:reference id})
                 (order :createtime)
                 (limit 1))))

(defn add-post! [post-data]
  (insert! posts post-data))

(defn get-comment [id]
  (first (select comments
                 (with users)
                 (with comments)
                 (with posts)
                 (where {:reference id})
                 (order :createtime)
                 (limit 1))))

(defn add-comment! [comment-data]
  (insert! comments comment-data))
