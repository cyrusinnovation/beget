(ns leiningen.gae
  (use [lancet.core :only [exec]])) ;; The exec ant task.

(defn usage []
	(println "Call this target as \"lein server start\" or \"lein server stop\"")
	(System/exit 0))

(defn run-shell-command [cmd & args]
  (apply exec {:executable cmd :spawn "true"} args))

;; You should define the vars
;; appserver-sdk-install-path, appserver-address, and appserver-port
;; in your project.clj file.
(defn dev-appserver []
	(run-shell-command "java"
										 "-ea"
										 "-cp"
										 (str leiningen.core/appserver-sdk-install-path "/lib/appengine-tools-api.jar")
										 "com.google.appengine.tools.KickStart"
										 "com.google.appengine.tools.development.DevAppServerMain"
										 (str "--address=" leiningen.core/appserver-address)
										 (str "--port=" leiningen.core/appserver-port)
										 "war"))

(defn kill-appserver []
	(run-shell-command "script/kill_appserver.sh"))

(defn gae [project & args]
	(let [command (first args)]
		(cond
		 (empty? command) (usage)
		 (= "start" command) (dev-appserver)
		 (= "stop" command) (kill-appserver)
		 :else (usage))))
