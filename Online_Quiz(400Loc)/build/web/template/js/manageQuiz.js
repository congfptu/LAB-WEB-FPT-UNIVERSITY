/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function renderPager(id, pageindex, totalpage, gap)
{
    //get container of id 
    var container = document.getElementById(id);
    var i;
    var begin = "<a href='managequiz?page=";

    try {
        //show first if pageindex > gap page+1
        if (pageindex > gap + 1)
        {
            container.innerHTML += begin + 1 + "'>" + "first</a>";
        }

        //show "gap" pages before current page
        for (i = pageindex - gap; i < pageindex; i++)
        {
            if (i >= 1)
            {
                container.innerHTML += begin + i + "'>" + i + "</a>"
            }
        }

        //show current page
        container.innerHTML += "<span>" + pageindex + "</span>"
        //show "gap" pages after current page
        for (i = pageindex + 1; i <= pageindex + gap; i++)
        {
            if (i <= totalpage)
            {
                container.innerHTML += begin + i + "'>" + i + "</a>"
            }
        }

        //show last page if current page < totalpages-gap
        if (pageindex < totalpage - gap)
        {
            container.innerHTML += begin + totalpage + "'>" + "last</a>"
        }
    } catch (err) {
        container.innerHTML += err;
    }
}
function ask() {
    if (confirm('Do you want to delete'))
        return true;
    return false;
}



