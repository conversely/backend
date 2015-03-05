(ns conversely.core
  (:require [conversely.db.core :as db]
            [crypto.password.bcrypt :as bcrypt]
            [clj-time.core :as timec]))

(defn get-user
  "load user from database by id"
  [id]
  (let [{:keys [firstname lastname password createtime]} (db/get-user id)]
    (cond
          (nil? createtime) nil
     :else
     {:firstname firstname :lastname lastname :createtime createtime})))

(defn auth-user
  "validates user with password"
  [id password]
  (bcrypt/check password (:password (db/get-user id))))

(defn create-user
  "add user to database"
  [firstname lastname password]
  (let [user-info
        {:firstname firstname
         :lastname lastname
         :password (bcrypt/encrypt password)}]
    (db/add-user! (assoc user-info :createtime (timec/now)))))

(defn get-post
  "load post from database by id"
  [id]
  (let [{:keys [user_id title body reference createtime]} (db/get-post id)]
    (cond
          (nil? createtime) nil
     :else
     {:author user_id
      :title title
      :body body
      :reference reference
      :createtime createtime})))

(defn create-post
  "add a post to the db"
  [user_id title body]
  (let [post-info {:user_id user_id :body body :title title}]
    (db/add-post! (assoc post-info {:createtime (timec/now)}))))

(defn get-comment
  "load comment from database by id"
  [id]
  (let [{:keys [user_id parent_id post_id title body reference createtime]}
         (db/get-comment id)]
    (cond
          (nil? createtime) nil
     :else
     {:author user_id
      :title title
      :body body
      :reference reference
      :createtime createtime
      :post-id post_id
      :parent-id parent_id})))

(defn create-comment
  "add a comment to the db"
  ([user-id post-id title body] (create-comment user-id post-id nil title body))
  ([user-id post-id parent-id title body]
   (db/add-comment! {:user_id user-id
                     :post_id post-id
                     :parent_id parent-id
                     :title title
                     :body body})))
