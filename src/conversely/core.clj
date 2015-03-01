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

(defn create-user
  "add user to database"
  [firstname lastname password]
  (db/add-user! (assoc {:firstname firstname
                        :lastname lastname
                        :password (bcrypt/encrypt password)}
                       :createtime (timec/now))))

(defn get-post
  "load post from database by id"
  [id]
  (let [{:keys [user_id title body reference createtime]}]
    (cond
          (nil? createtime) nil
     :else
     {:author user_id
      :title title
      :body body
      :reference reference
      :createtime createtime})))
