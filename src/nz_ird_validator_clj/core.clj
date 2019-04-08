(ns nz-ird-validator-clj.core
  (:gen-class))

(defn- convert-int [s]
  (Integer/parseInt (str s)))


(defn- get-check-digit [ird, weight-factor]
  (let [f (mapv convert-int ird)
        s (mapv convert-int weight-factor)
        check-digit (mod (apply + (map * f s)) 11)]
    (if (= 0 check-digit)
      0
      (- 11 check-digit))))


(defn- remove-dashes [ird]
  (convert-int (clojure.string/replace ird #"-" "")))


(defn- is-valid-IRD-Number [ird-number]
  (if (< 10000000 ird-number 150000000)
    (let [last-digit (str (first (take-last 1 (str ird-number))))
          ird (format "%08d" (convert-int (clojure.string/join "" (drop-last (str ird-number)))))
          first-check (get-check-digit ird "32765432")
          second-check (get-check-digit ird "74325276")]
      (if (< first-check 10)
        (= first-check (convert-int last-digit))
        (if (< second-check 10)
          (= second-check (convert-int last-digit))
          false)))
    false))


(defn nz-ird-validator
  [ird-number]
  (-> ird-number
      remove-dashes
      is-valid-IRD-Number))
