function main(game) {
    var indices = [];
    for (var i=0; i<game.length; i++) {
        if (game[i] == "-") {
            indices.push(i);
        }
    }
    console.log(randomFrom(indices));
}

function randomFrom(arr) {
    return arr[Math.floor(Math.random() * arr.length)]
}