// ---------------------------
//
// HOMEWORK
//
// You can use either Groovy or Java.
//
// Design a routine that will calculate the average Product price per Group.
//
// The Price of each Product is calculated as:
// Cost * (1 + Margin)
//
// Assume there can be a large number of products.
//
// Plus points:
// - use Groovy and its closures
// - make the category look-up performance effective
// - use method Collection.inject

// contains information about [Product, Group, Cost]
def products = [
    ["A", "G1", 20.1],
    ["B", "G2", 98.4],
    ["C", "G1", 49.7],
    ["D", "G3", 35.8],
    ["E", "G3", 105.5],
    ["F", "G1", 55.2],
    ["G", "G1", 12.7],
    ["H", "G3", 88.6],
    ["I", "G1", 5.2],
    ["J", "G2", 72.4]]
 
// contains information about Category classification based on product Cost
// [Category, Cost range from (inclusive), Cost range to (exclusive)]
// i.e. if a Product has Cost between 0 and 25, it belongs to category C1
// ranges are mutually exclusive and the last range has a null as uppoer limit.
def category = [
    ["C3", 50, 75],
    ["C4", 75, 100],
    ["C2", 25, 50],
    ["C5", 100, null],
    ["C1", 0, 25]]

// contains information about margins for each product Category
// [Category, Margin (either percentage or absolute value)]
def margins = [
    "C1" : "20%",
    "C2" : "30%",
    "C3" : "0.4",
    "C4" : "50%",
    "C5" : "0.6"]
 
// ---------------------------
//
// YOUR CODE GOES BELOW THIS LINE
//
// Assign the 'result' variable so the assertion at the end validates
//
// ---------------------------
int s = products.size();
int g1Count; double g1Cost; double g1Price; double g1Sum; double g1Mar; double g1Avg;
int g2Count; double g2Cost; double g2Price; double g2Sum; double g2Mar; double g2Avg;
int g3Count; double g3Cost; double g3Price; double g3Sum; double g3Mar; double g3Avg;

for (int i = 0; i<s; i++){
    if(products[i].get(1).equals("G1")){ //Determine Category Group
        g1Count++;                       //Grab divide by #
        g1Cost = products[i].get(2);     //Grab Cost
        if(g1Cost < 25){                 //Determine Margin based on Cost
            g1Mar = 0.2;
        }
        else if(g1Cost < 50){
            g1Mar = 0.3;
        }
        else if(g1Cost < 75){
            g1Mar = 0.4;
        }
        else if(g1Cost < 100){
            g1Mar = 0.5;
        }
        else{
            g1Mar = 0.6
        }
        
        g1Price = g1Cost * (1 + g1Mar);   //Determine Price based on Cost and Margin
        g1Sum = g1Sum + g1Price;          //Add to Sum
    }
}

for (int i = 0; i<s; i++){
    if(products[i].get(1).equals("G2")){  //See Method for G1
        g2Count++;
        g2Cost = products[i].get(2);
        if(g2Cost < 25){
            g2Mar = 0.2;
        }
        else if(g2Cost < 50){
            g2Mar = 0.3;
        }
        else if(g2Cost < 75){
            g2Mar = 0.4;
        }
        else if(g2Cost < 100){
            g2Mar = 0.5;
        }
        else{
            g2Mar = 0.6
        }
        
        g2Price = g2Cost * (1 + g2Mar);
        g2Sum = g2Sum + g2Price;
    }
}

for (int i = 0; i<s; i++){
    if(products[i].get(1).equals("G3")){  //See Method for G1
        g3Count++;
        g3Cost = products[i].get(2);
        if(g3Cost < 25){
            g3Mar = 0.2;
        }
        else if(g3Cost < 50){
            g3Mar = 0.3;
        }
        else if(g3Cost < 75){
            g3Mar = 0.4;
        }
        else if(g3Cost < 100){
            g3Mar = 0.5;
        }
        else{
            g3Mar = 0.6
        }
        
        g3Price = g3Cost * (1 + g3Mar);
        g3Sum = g3Sum + g3Price;
    }
}

g1Avg = (g1Sum / g1Count);
g1Avg = g1Avg.round(1);
g2Avg = (g2Sum / g2Count);
g2Avg = g2Avg.round(1);
g3Avg = (g3Sum / g3Count);
g3Avg = g3Avg.round(1);

def result = [
    "G1" : g1Avg,
    "G2" : g2Avg,
    "G3" : g3Avg
    ]

// ---------------------------
//
// IF YOUR CODE WORKS, YOU SHOULD GET "It works!" WRITTEN IN THE CONSOLE
//
// ---------------------------
assert result == [
    "G1" : 37.5,
    "G2" : 124.5,
    "G3" : 116.1
  ] : "It doesn't work"
 
println "It works!"
