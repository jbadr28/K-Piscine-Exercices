//declare two variables, admin and name
let admin, name;

// Assign the value "John" to name
name="John";

//Copy the value from name to admin.
admin = name;

//Show the value of admin using alert (must output “John”).
alert( admin )

//variable for our planet
let ourPlanetName = "the Earth";

//variable for current website visitor name

let currentUserName = "jbadr28";

//lowercase or upercase
// const BIRTHDAY = '01.01.1010'
// const age = caculateAge(BIRTHDAY)

//what is the output of the script
let name1 = "Ilya";

alert( `hello ${1}` ); // ?  hello 1

alert( `hello ${"name1"}` ); // ? hello name1

alert( `hello ${name1}` ); // ? hello ilya

/*What are the final values of all variables 
// a, b, c and d after the code below?*/
// let a = 1, b = 1;

// let c = ++a; // ?
// let d = b++; // ?
/*the final values are
a= 2 ,  b=2, c=2 , d=1 */

//What are the values of a and x after the code below?
// let a = 2;

// let x = 1 + (a *= 2);
//a = 4, x = 5


//What are results of these expressions?
"" + 1 + 0 // 10
"" - 1 + 0 // -1
true + false //  1
6 / "3" // 2
"2" * "3" // 6
4 + 5 + "px" // 9px
"$" + 4 + 5 // $45
"4" - 2 // 2
"4px" - 2 // Nan
"  -9  " + 5 // -9   5
"  -9  " - 5 // -14
null + 1 // 1
undefined + 1 // Nan
" \t \n" - 2 // -2


//Why? Fix it. The result should be 3.
let a = prompt("First number?", 1);
let b = prompt("Second number?", 2);

alert(a + b);

//fixed version to make a+b = 3
let a1 = Number(prompt("First number?", 1));
let b1 = Number(prompt("Second number?", 2));

alert(a1 + b1);


//What will be the result for these expressions?

5 > 4                  //  true
"apple" > "pineapple"  //  false
"2" > "12"             //  true
undefined == null      //  true
undefined === null     //  false
null == "\n0\n"        //  false
null === +"\n0\n"      //  false

//Will alert be shown?
if ("0") {
    alert( 'Hello' );
  }// yes because "0" is not an empty string

//simple if else
// let value = prompt('What is the official name of JS?', '');

//     if (value === 'ECMAScript') {
//       alert('Right!');
//     } else {
//       alert("You don't know? ECMAScript!");
//     }


// using if else to return differnce values based on condition

let value = prompt('give a number',0)

if(value>0) {
    alert(1)
}else if(value<0){
    alert(-1)
}else{
    alert(0)
}

//Rewrite this if using the conditional operator '?':
let result;

if (a + b < 4) {
  result = 'Below';
} else {
  result = 'Over';
}
//the same code but replacing if by ? operator
result = (a + b < 4 ) ?  'Below': 'Over'

//Rewrite if..else using multiple ternary operators '?'
let message;

if (login == 'Employee') {
  message = 'Hello';
} else if (login == 'Director') {
  message = 'Greetings';
} else if (login == '') {
  message = 'No login';
} else {
  message = '';
}
//replacing if  else by ?

message = login == 'Employee' ? 'Hello' :
          login == 'Director' ? 'Greetings' :
          login == '' ? 'No login' : '' ;

//What is the code below going to output?
alert( null || 2 || undefined ); // 2

//What will the code below output?
alert( alert(1) || 2 || alert(3) );
//since the alert function doesnt have a return type
// so the code will show a popup of type alert 
// and the message will be 2

//What is this code going to show?
alert( 1 && null && 2 ); //null

//What will this code show?
alert( alert(1) && alert(2) );
//since the alert function doesnt have a return type
// so the code will show a popup of type alert 
// and the message will be 1

//What will the result be?
alert( null || 2 && 3 || 4 );
/* the presedence of && operator is higher than ||
so the result of (2 && 3) is 3 the last operands
so (null || 2 && 3 || 4) is equavalent to (null || 3 || 4)
so the result is 3
*/

//Write an if condition to check that age is between 
//14 and 90 inclusively.
// let age;
// age = +prompt('Enter an Age',0)
// if(14<=age && 90>=age){
//   alert('age is in the requested range')
// }

//Check the range outside
//Write an if condition to check that age 
//is NOT between 14 and 90 inclusively.
let age;
if(14 > age || 90 < age){}
if (!( 14 <= age && 90 >= age)){}

//What will the results of the expressions be inside if(...)?
if (-1 || 0) alert( 'first' ); // true
if (-1 && 0) alert( 'second' ); // false
if (null || -1 && 1) alert( 'third' ); // true

//check the login
login = prompt('Enter your login','');
if (login==='Admin'){
  password = prompt('Enter your password','');
  if(password==='Welcome!'){
    alert('welcome');
  }else if(password === '' || password === null){
    alert('Canceled');
  }else{
    alert('Wrong password');
  }
}else if (login=== '' || login===null){
  alert('Canceled');
}else{
  alert('I dont know you');
}

//Last loop value
//let i = 3;

while (i) {
  alert( i-- );
}// the last value fo i is 1

//Which values does the while loop show?
let i = 0;
while (++i < 5) alert( i );
//this loop will alert (1, 2, 3, 4)

let j = 0;
while (j++ < 5) alert( j );
//this loop will alert (1,2,3,4,5)


//Which values get shown by the "for" loop?
for (let i = 0; i < 5; i++) alert( i );
//this for loop will alert (0,1,2,3,4)

for (let i = 0; i < 5; ++i) alert( i );
//this for loop will alert (0,1,2,3,4)

//Output even numbers in the loop
for(let i=2;i<11;i++){
  if (i%2===0){
    alert(i);
  }
}

//Replace "for" with "while"
for (let i = 0; i < 3; i++) {
  alert( `number ${i}!` );
}
//
let index = 0
while(index<3){
  alert( `number ${index}!` );
  index++;
}

//Repeat until the input is correct
inputchecker: for(;;){
  let num = +prompt('Enter a number greater than 100',0);
  if(num>=100) {
    break inputchecker;
  }
}

//Is "else" required?
function checkAge(age) {
  if (age > 18) {
    return true;
  } else {
    // ...
    return confirm('Did parents allow you?');
  }
}//in this case the function deos not need an else statement
// and wiil workd exactly the same without it
function checkAge(age) {
  if (age > 18) {
    return true;
  }
  // ...
  return confirm('Did parents allow you?');
}
//Rewrite the function using '?' or '||'
function checkAge(age) {
  if (age > 18) {
    return true;
  } else {
    return confirm('Did parents allow you?');
  }
}
//reformat
function checkAge(age){
  return age>18 ? true : confirm('Did parents allow you?');
}

//Function min(a, b)
function min(a, b) {
  return a < b ? a : b;
}

//Function pow(x,n)
function pow(x,n){
  return x**n;
}

//Replace Function Expressions with arrow functions in the code below:
function ask(question, yes, no) {
  if (confirm(question)) yes();
  else no();
}

ask(
  "Do you agree?",
  function() { alert("You agreed."); },
  function() { alert("You canceled the execution."); }
);

