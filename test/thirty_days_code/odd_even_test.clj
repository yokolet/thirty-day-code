(ns thirty-days-code.odd-even-test
  (:require [clojure.java.io :as io]
            [clojure.test :refer :all]
            [thirty-days-code.core-test :as core-test]
            [thirty-days-code.odd-even :refer :all]))

(defn odd-even-test-fixture [f]
  (core-test/wrap-test "test-data/odd-or-even.txt" f))
(def expected ["Hce akr" "Rn ak"])

(use-fixtures :once odd-even-test-fixture)
(deftest odd-even-test
  (testing "create two strings made by even and odd indices of given string"
    ;; no need to use the first number in the test cases
    (Integer/parseInt (clojure.string/trim (read-line)))
    (doseq [[s e] (map list (line-seq (java.io.BufferedReader. *in*))
                       expected)]
      (let [result (odd-even s)]
        (is (= e (str (:even result) " " (:odd result))))))))

(run-tests)

