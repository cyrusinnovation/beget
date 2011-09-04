(ns leiningen.server
	(use [leiningen.core :only [dev-appserver kill-appserver]]))

(declare usage)

;; Call this as "lein server start" or "lein server stop"
(defn server [project & args]
	(let [command (first args)]
		(cond
		 (empty? command) (usage)
		 (= "start" command) (dev-appserver)
		 (= "stop" command) (kill-appserver)
		 :else (usage))))

(defn usage []
	(println "Call this target as \"lein server start\" or \"lein server stop\"")
	(System/exit 0))
