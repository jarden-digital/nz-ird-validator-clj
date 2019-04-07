(ns nz-ird-validator-clj.core
  (:gen-class))

(defn convertInt [s]
  (Integer. (re-find  #"\d+" s )))

(defn removeDashes [ird]
  (convertInt (clojure.string/replace ird #"-" "")))

(defn isValidIRDNumber [irdNumber]
  (cond
    (< irdNumber 10000000) false
    (> irdNumber 150000000) false
    :else true))

(defn -main
  [irdNumber]
  (isValidIRDNumber (removeDashes irdNumber)))
