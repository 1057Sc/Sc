/**
 * Created by Sc on 5/6/2019.
 */
$('#example').dataTable(
    {
        data: [
            {
                "name":    "Tiger Nixon1",
                "position":   "System Architect1",
                "phone": { "plain": 5552368, "filter": "5552368 555-2368", "display": "555-2368" },
                "salary":    "$3,1201",
                "start_date": "2011/04/25",
                "office":    "Edinburgh1",
                "extn":    "54211"
            },
            {
                "name":    "Tiger Nixon2",
                "position":   "System Architect2",
                "phone": { "plain": 5552368, "filter": "5552368 555-2368", "display": "555-2368" },
                "salary":    "$3,1202",
                "start_date": "2011/04/25",
                "office":    "Edinburgh2",
                "extn":    "54212"
            },
            {
                "name":    "Tiger Nixon3",
                "position":   "System Architect3",
                "phone": { "plain": 5552368, "filter": "5552368 555-2368", "display": "555-2368" },
                "salary":    "$3,1203",
                "start_date": "2011/04/25",
                "office":    "Edinburgh3",
                "extn":    "54213"
            }

        ],

        columnDefs: [
            {
                "targets": 0,
                "searchable": false
            },
            {
                "targets": [1,2,3],
                "orderData": [ 2, 3, 4 ],
                "searchable": false
            },
            {
                "targets": [-3,-4],
                "orderable": false,
                "searchable": false
            }
        ],

        columns: [
            { "name": "name",
                "cellType": "th",
                "orderDataType": "dom-text",
                "orderSequence": [ "desc","asc", "asc" ],
                "className": "my_class",
                "contentPadding": "mmm",
                "createdCell": function (td, cellData, rowData, row, col) {
                    if ( row < 1 ) {
                        $(td).css('color', 'red');
                    }
                },
                "data": "name",
                "searchable": true,
                "title": "My Name"
            },
            {
                "data": "position",
                "render": function ( data, type, full, meta ) {
                    return '<a href="'+data+'">' + data + '</a>';
                }
            },
            {
                "data": 'phone',
                "render": {
                    "_": "plain",
                    "filter": "filter",
                    "display": "display"
                }
            },
            { "data": "office" },
            { "data": "start_date", "type": "date" },
            { "data": "extn", "visible": false},
            { "data": "salary", "width": "20px"  },
            {
                "data": null,
                "orderable": false,
                "defaultContent": "<button>Edit</button>"
            }

        ]
    }
);