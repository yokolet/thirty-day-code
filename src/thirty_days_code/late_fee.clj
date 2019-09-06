;; https://www.hackerrank.com/challenges/30-nested-logic/problem
(ns thirty-days-code.late-fee)

(defn late-fee []
  (let [[ad am ay] (mapv #(Integer/parseInt %) (clojure.string/split (read-line) #"\s"))
        [ed em ey] (mapv #(Integer/parseInt %) (clojure.string/split (read-line) #"\s"))
        em (if (< ay ey) (+ 12 em) em)
        ed (if (< am em) (+ 31 ed) ed)]
    (cond
      (< ey ay) (println 10000)
      (< em am) (println (* 500 (- am em)))
      (< ed ad) (println (* 15 (- ad ed)))
      :else (println 0))))

