export function setupAjax(url, data){
   return $.ajaxSetup({
        type:"POST",
        url: url,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8"
        //dataType: "json" for now just generic string because I dont have anything to really return. 
    });
}
