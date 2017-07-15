(ns json-web-key.core-test
  (:require [clojure.test :refer :all]
            [json-web-key.core :refer :all]))

(deftest a-test
  (testing "make publickey."
    (is (not= nil
              (-> {:kty "RSA"
                   :n "l9Cn5qmr7VFKIed9RQIZPdenYp-V1BDM1wMg7Rpkl8mNQ7qsnJWuK8JKQoIljbwr9L1kKikKOR37z1prV0ZTQQao73YsB34OLbi25g0Xcr32j5giQDMxmFxmrYN1LG-T4qEOI4hE52Bafr5jBuZwL56HeuEU5G-QunGrNieGcfdVFXVW8-f9UBkJmoF_Dw_H38wNKif79tGKD2XXdG-VjT-Pg2nbpzQ6fIXunzaaW9aUyoNZWpQQ9_QBqgEApHAP5qWGQsUQLwzkiUr1Du51ERLC7nm3B-pLFqIlRmqiWVtUAdF0wkKaCQXyvFS2KabG9D4aX0T_MKESsV7T6wwvsQ"
                   :e "AQAB"}
                  (jwk->publickey :key-fn keyword))))))
