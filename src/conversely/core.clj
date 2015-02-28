(ns conversely.core
  (:require [conversely.db.core :as db]))

(defn get-user
  "load user from database"
  [id]
  (let [{:keys [firstname lastname password createtime]} (db/get-user id)]
    (cond
          (nil? createtime) nil
     :else
     {:firstname firstname :lastname lastname :createtime createtime})))
