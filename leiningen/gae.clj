(ns leiningen.gae
  (use [lancet.core :only [exec]])) ;; The exec ant task.

(defn usage []
	(println "Call this target as \"lein server start\" or \"lein server stop\"")
	(System/exit 0))

(defn run-shell-command [cmd & args]
  (apply exec {:executable cmd :spawn "true"} args))

;; You should define 
;; gae-appserver-sdk-install-path, gae-appserver-address, and gae-appserver-port
;; in your project.clj file.
(defn dev-appserver [project]
	(let [appserver-sdk-install-path (project :gae-appserver-sdk-install-path)
				appserver-address (project :gae-appserver-address)
				appserver-port (project :gae-appserver-port)]
	(run-shell-command "java"
										 "-ea"
										 "-cp"
										 (str appserver-sdk-install-path "/lib/appengine-tools-api.jar")
										 "com.google.appengine.tools.KickStart"
										 "com.google.appengine.tools.development.DevAppServerMain"
										 (str "--address=" appserver-address)
										 (str "--port=" appserver-port)
										 "war")))

(defn kill-appserver []
	(run-shell-command "script/kill_appserver.sh"))

(defn gae [project & args]
	(let [command (first args)]
		(cond
		 (empty? command) (usage)
		 (= "start" command) (dev-appserver project)
		 (= "stop" command) (kill-appserver)
		 :else (usage))))
