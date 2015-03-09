(ns conversely.util)

(defn uuid 
  "create a random uuid"
  [] (str (java.util.UUID/randomUUID)))
