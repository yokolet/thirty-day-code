;; https://www.hackerrank.com/challenges/30-binary-numbers/problem
(ns thirty-days-code.count-ones)

(defn count-ones [n]
  (let [bstr (Integer/toBinaryString n)]
    (apply max (map count (clojure.string/split bstr #"0+")))))

(comment

  (def n (Integer/parseInt (clojure.string/trim (read-line))))
  (count-ones n)
  )
