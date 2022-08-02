var body = document.getElementsByTagName("body");
var calculator = document.getElementById("calculator");
var rowDropdown = document.getElementById("numberOfRows");
var columnDropdown = document.getElementById("numberOfColumns");
var table = document.getElementById("matricTable");
var drawButton = document.getElementById("drawMatricButton");
var divDimensionSelector = document.getElementById("dimensionSelector");

/*
 * This function creates a new div and a button,it returns the div created
 * the button created is the draw button that is clicked after the user has selected the dimensions.
 *
 */
function createDiv(idForRow, idForColumn) {
  //create the div
  var div = document.createElement("div");
  return div;
}
function createButton(divElement, idForRow, idForColumn) {
  var row = idForRow;
  var col = idForColumn;
  //create the button
  var button = document.createElement("button");
  button.innerHTML = "DRAW";

  //give the button an onclick function
  button.addEventListener("click", function () {
    drawButtonOnclick(row, col);
  });

  divElement.appendChild(button);
}

/*
 * This function creates a label for the selectors,
 * it takes in the div element it will be appended to, the id of the selector, and the dimension tyep(row/column)
 * it returns the label created
 * the button created is the draw button that is clicked after the user has selected the dimensions.
 */
function createLabel(id, dimensionsType) {
  //create the label for the dropdown
  var label = document.createElement("label");
  label.setAttribute("htmlFor", id + dimensionsType);

  //create the text that the label will display
  label.insertAdjacentText(
    "afterbegin",
    "Choose a number of " + dimensionsType + ":"
  );

  return label;
}

/*
 * This function creates the drop down for the dimension,
 * it creates a new div, new labels and the options for the selectors
 */
function dropDownCreator(id) {
  //create the new div
  var div = document.createElement("div");

  //create labels for the rows & columns
  var rowLabel = createLabel(id, "Rows");
  var columnLabel = createLabel(id, "Columns");

  //create the select tag for the row
  var selectRows = document.createElement("select");
  selectRows.setAttribute("id", id + "Rows");
  //create the options for the row
  createOptions(selectRows);

  //create the select tag for the columns
  var selectCols = document.createElement("select");
  selectCols.setAttribute("id", id + "Columns");
  //create the options for the column
  createOptions(selectCols);

  //append the row label to the div
  div.appendChild(rowLabel);
  //append the select row to the div
  div.appendChild(selectRows);

  //append the column label to the div
  div.appendChild(columnLabel);
  //append the select column to the div
  div.appendChild(selectCols);

  // create the button
  createButton(div, id + "Rows", id + "Columns");

  divDimensionSelector.appendChild(div);

  //add the button
}

function createOptions(element) {
  //create the options
  var option;
  for (let i = 0; i < 10; i++) {
    //create an option
    option = document.createElement("option");
    // set the value
    option.setAttribute("value", i);

    //create the text and append it to the option
    option.innerHTML = i;
    //append the option to the select
    element.appendChild(option);
  }
}

function setup() {
  var calc = calculator.options[calculator.selectedIndex].value;
  switch (calc) {
    case "add":
      dropDownCreator("m1");
      dropDownCreator("m2");
  }
}

function drawButtonOnclick(row, col) {
  //Get the values selected for the rows and column
  var numRows = row.options[row.selectedIndex].value;
  var numCol = col.options[col.selectedIndex].value;
  //console.log(numRows + " x " + numCol);
  drawTable(numRows, numCol);
}

/*
 ** This function draws a matric when given dimensions.
 ** It draws the rows of the matric and appends it to the table,
 ** then it draws the columns, creates input fields for the column, then appends it to the row
 */
function drawTable(rows, column) {
  //clear the current table
  table.innerHTML = "";

  //first we create the rows
  for (let i = 0; i < rows; i++) {
    //create a new row
    var newRow = document.createElement("tr");

    //add the row to the table
    table.appendChild(newRow);

    //now for the columns
    for (let j = 0; j < column; j++) {
      //create a new column
      var newCol = document.createElement("td");

      //create the input field
      var input = document.createElement("input");
      input.type = "number";

      // the input to the column
      newCol.appendChild(input);

      //append the new column to the row
      newRow.appendChild(newCol);
    }
  }
}
