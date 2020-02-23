
function sendSms(e)
{
    console.log(e);
var data=$('#number').val();
        $.ajax({
            cache: false,
            type: "GET",
            url:"/sendSms",
             async:true,
            //返回的内容的格式
            dataType: "json",
            data:"number="+data,
            success: function(data) {
                if(data.code==443){
                    alert(data.message);
                }else if(data.code==200){
                    alert(data.message);
                }
            },
        });
}