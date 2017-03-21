var TableAjax = function () {

    

    var handleRecords = function () {

        var grid = new Datatable();
        
        

       /* grid.init({
            src: $("#datatable_ajax"),
            onSuccess: function (grid) {
                // execute some code after table records loaded
            },
            onError: function (grid) {
                // execute some code on network or other general error  
            },
            loadingMessage: 'Loading...',
            dataTable: { // here you can define a typical datatable settings from http://datatables.net/usage/options 
                
                "pageLength": 10, // default record count per page
                //"processing": true,
    			//"serverSide": true,
    			"bPaginate": true,
    			//"pagingType": 'simple_numbers',
                "ajax": {
                    "url": ctx+"/menu/list", // ajax source
                },
                "columns": [
            				{"data": "id"},
            				{"data": "name"},
            				{"data": "href"}
            			]
            }
        });*/

        // handle group actionsubmit button click
       
    }

    return {

        //main function to initiate the module
        init: function () {

            handleRecords();
        }

    };

}();