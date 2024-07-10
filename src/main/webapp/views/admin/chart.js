//
//
// $(document).ready(function(){
//
//
//     $('#myTable').on('draw.dt', function () {
//         $('.edit_btn').click(function () {
//             console.log('Nút chỉnh sửa được click 111');
//             $('#edit').show();
//             $.ajax({
//                 url:`admin/movie`,
//                 type:"GET"
//             })
//         });
//     });
//
//     $("#close").on('click',function (){
//         $('#edit').hide();
//     })
// });
//
// const edit_btn = document.querySelector(".edit_btn");
// console.log(edit_btn)
// // $.ajax({
// //     url: "${pageContext.request.contextPath}/admin/revenue",
// //     type: "POST",
// //     contentType: 'application/json;charset=UTF-8',
// //     data: JSON.stringify({
// //         months: selected_x1,
// //         theaters: selected_x2
// //     }),
// //     dataType: "json",
// //     success: function (data) {