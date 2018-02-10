var elems = {"name":"#name", "ssn":"#ssn", "zip":"#zip", "email":'#email', "phone":'#phone', "birthday":'#birthday', "accept":'#accept'};

var problemsID = '#problems ol';

var invisLi = '<li class="hidden"></li>';

$('document').ready(function()
{

    console.log('Doc is ready!');

});

/*******************************************************************************
 * @returns Whether or not <code>str</code> is between (by default) 4-50
 *          characters.
 */
function validateString(str, bot=4, top=50)
{
    return (str.length >= bot && str.length <= top);
}

/*******************************************************************************
 * @returns Whether or not <code>ssn</code> is a valid Social Security number.
 */
function validateSSN(ssn, len=9)
{
    var s = ssn.replace(/[^0-9]/g, "") // delete all non-numbers

    return (s.length == len); // 111-22-3333 sans hyphens
}



$('#sign-up').on('submit', function(e)
{ // someone wants to submit
    e.preventDefault();

    var valid = true;

    if (!validateString($('#name').val(), 4, 50))
    {
    valid = false;
    alert("Name must be between 4 and 50 letters!");
    }

    if(!validateSSN($('#ssn').val()))
    {
    valid = false;
    alert("Invalid SSN!");
    }
    
    if(!validateString($('#street')), 4, 50)
    {
        valid = false;
        alert("Street must be between 4 and 50 letters!");
    }
    
    if(!validateString($('#city')), 3, 50)
    {
        valid = false;
        alert("City must be between 3 and 50 letters!");
    }
    
    if(!valid)
    {
    
    }
    else
    {

    }

});