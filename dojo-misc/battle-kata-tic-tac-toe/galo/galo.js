function main(game) {
    let indices = [];
    for (let i=0; i<game.length; i++) {
        if (game[i] == "-") {
            indices.push(i);
        }
    }
    console.log(randomFrom(indices));
}

function randomFrom(arr) {
    return arr[Math.floor(Math.random() * arr.length)]
}