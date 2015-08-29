
    function sendPingOtherHost(hostname){
        document.domain = "swacorp.com";
        var location = window.location;
        var path = "webExample/Ping";
        var url = location.protocol + "//" + hostname + ":" + location.port + "/" + path
        var options = {
        	
            onSuccess:  function(request){
                $("response").innerHTML = request.responseText;
                logger.info("response = \n" + request.responseText);
            },
            onFailure: function(request){
                $("response").innerHTML = request.statusText;
            },
            onException: function(request, ex){
                $("response").innerHTML = ex;
            }
        };
        logger.info("sending ping request to " + url);
        new Ajax.Request(url, options);
        
    }
