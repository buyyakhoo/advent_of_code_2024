import fs from 'fs';

const file = fs.readFileSync("./input.txt", "utf8")

const data_all = file.replaceAll("\r", "")
                    .split("\n")
                    .map(d => d.split(",")
                                .map(n => parseInt(n))
                        )
                    // .filter((f, idx) => idx < 12) // 1024
                    
const data = data_all.filter((f, idx) => idx < 1024)

const x_t_use = data_all.map(n => n[0]).sort((a, b) => b-a)[0]
const y_t_use = data_all.map(n => n[1]).sort((a, b) => b-a)[0]

const count_list = []
const save_cor_list = new Map()

const find_shortest_path = (x=0, y=0, x_target, y_target, count=0) => {
    
    if (x < 0 || y < 0 || x > x_target-1 || y > y_target-1) {
        return
    }

    if (x === x_target-1 && y === y_target-1) {
        count_list.push(count)
        return
    }

    const cor = `${x},${y}`
    if (save_cor_list.get(cor) && save_cor_list.get(cor) <= count) {
        return
    }

    save_cor_list.set(cor, count)

    if (data.find(data_cor => data_cor[0] === x && data_cor[1] === y)) {
        return
    }

    // this find the counting

    find_shortest_path(x+1, y, x_target, y_target, count+1)
    find_shortest_path(x, y+1, x_target, y_target, count+1)
    find_shortest_path(x-1, y, x_target, y_target, count+1)
    find_shortest_path(x, y-1, x_target, y_target, count+1)   
}

find_shortest_path(0, 0, x_t_use+1, y_t_use+1, 0)
console.log(`result: ${count_list.sort((a, b) => a-b)[0]}`)

// fs.writeFileSync('./output.txt', 
//     JSON.stringify(Array.from(save_cor_list)),
//     () => {
//         console.log('successfully saved')
//     }
// )