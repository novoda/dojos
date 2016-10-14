var played = [];

function main(game) {
    let plays = [
      [8, 2, 14, 10, 6, 4, 0, 12],
      [6, 2, 4, 10, 6, 4, 0, 8, 12],
      [0, 2, 4, 6, 8, 10, 12, 14],
    ]

  for (var i=0; i<plays.length; i++) {
    if (tryToPlay(plays[i])) {

    }
  }
}



function tryToPlay(arr) {
  for (int i=0; i<arr.length; i++) {
    if (game[i] == "-") {
      play(i);
      return true;
    }
  }
  return false;
}

function getFreePositions(game) {
  let indices = [];
  for (let i=0; i<game.length; i++) {
    if (game[i] == "-") {
      indices.push(i);
    }
  }
  return indices;
}

function isMiddlemostFree(game) {
  return game[8] == "-";
}

function played(pos) {
  for (int i=0; i<played.length; i++) {
    if (played[i] == pos) {
        return true;
    }
  }
  return false;
}

function randomFrom(arr) {
    return arr[Math.floor(Math.random() * arr.length)]
}

function play(pos) {
  played.push(pos);
  console.log(""+pos)
}

var board; //=process.argv[2];
//board = "-,X,-,0,-,X,-,0,-";
main(board);