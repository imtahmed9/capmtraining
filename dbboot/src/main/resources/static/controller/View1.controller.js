sap.ui.define([
    "sap/ui/core/mvc/Controller",
    "sap/ui/thirdparty/jquery",
    "sap/ui/model/json/JSONModel",
    "anubhav/util/Service",
    'sap/m/MessageToast'
], function (Controller, jQuery, JSONModel, Service, MessageToast) {
    "use strict";

    return Controller.extend("anubhav.controller.View1", {
		onInit: function () {
			var oModel = new JSONModel();
			oModel.setData({
				"postPayload": {
					"companyName": "",
					"firstName": "",
					"lastName": "",
					"website": "",
					"email": "",
					"status": "A",
					"gstNo": "",
				},
				"vendor":{}
			});
	        sap.ui.getCore().setModel(oModel);


		},
		
		onSave: function() {
			var oPostPayload = this.getView().getModel().getProperty('/postPayload');
			var that = this;
			Service.callService('/newVendor', 'POST', oPostPayload).
			then(data=>{
				MessageToast.show('Data Saved...!');
				that.onLoadVendor();
			}).catch(err => {
				
			})
		},
		
        onLoadVendor: function () {
			var that = this;
			Service.callService('/newVendor', 'GET', {}).
			then(data=>{
				var oTable = that.getView().byId("idVendor");
                    this.getView().getModel().setProperty('/vendor', data._embedded.vendor)
                    oTable.bindRows('/vendor')
			}).catch(err => {
				
			})
            /*jQuery.ajax("/newVendor", {
                type: 'GET',
                success: function (data) {
                    var oTable = that.getView().byId("idVendor");
                    var oModel = new JSONModel();
                    oModel.setData(data._embedded);
                    sap.ui.getCore().setModel(oModel);
                    oTable.bindRows('/vendor')       
                },
                error: function (err) {
                    console.log(err);
                }
            });*/
        },
        onDelete: function () {
		    var oTable = this.getView().byId("idVendor");
		    var aIndices = oTable.getSelectedIndices();
		    var aSelectedObjectKeys = [];
			var that = this;
		    // Collect selected object keys
		    aIndices.forEach(function (iIndex) {
		        var sKey = oTable.getContextByIndex(iIndex).getObject()._links.self.href.split('/').pop(); // Use pop() to get the last segment
		        aSelectedObjectKeys.push(sKey);
		    });
		
		    // Perform delete operations
		    var aPromises = aSelectedObjectKeys.map(function (sKey) {
		        return Service.callService('/newVendor/' + sKey, 'DELETE', {});
		    }, this); // Bind this to ensure correct context
		
		    // Handle all promises
		    Promise.all(aPromises)
		        .then(function (results) {
					that.onLoadVendor();
		            MessageToast.show('Deleted Successfully!');
		        })
		        .catch(function (err) {
		            MessageToast.show('Error during deletion!');
		            console.error(err);
		        });
		}

    });
});
