sap.ui.define([
    "sap/ui/thirdparty/jquery"
	],
	function(jQuery) {
		return {
			callService: function (sUrl, sMethod, oPayload) {
	            return new Promise(function (resolve, reject) {
	                jQuery.ajax(sUrl, {
	                    type: sMethod,
	                    contentType: "application/json",
	                    data: sMethod !== "GET" ? JSON.stringify(oPayload) : null,
	                    success: function (data) {
	                        resolve(data);
	                    },
	                    error: function (err) {
	                        reject(err);
	                    }
	                });
	            });
	        },
		}
	}
)