;; https://www.hackerrank.com/challenges/30-review-loop/problem

(ns thirty-days-code.odd-even)

(defn odd-even
  "returns odd and even indices str"
  [s]
  (let [ss (seq s)]
    (loop [ss ss
           key :even
           result {:even "" :odd ""}]
      (if (empty? ss)
        result
        (recur (rest ss)
               (if (= key :even) :odd :even)
               (update-in result [key] str (first ss)))))))

(defn odd-even2
  [s]
  (let [ss (seq s)
        keys [:even :odd]
        f (fn [acc v]
            (-> acc (update-in [(nth keys (:idx acc))] str v)
                (update-in [:idx] bit-xor 1)))]
    (reduce f {:idx 0 :even "" :odd ""} ss)))

(comment
  ;; the first line is the number of test cases from stdin
  ;; after the second line, input strings come from stdin
  (def N (Integer/parseInt (clojure.string/trim (read-line))))
  (doseq [s (line-seq (java.io.BufferedReader. *in*))]
    (let [result (odd-or-even s)]
      (println (:even result) (:odd result))))

  )

