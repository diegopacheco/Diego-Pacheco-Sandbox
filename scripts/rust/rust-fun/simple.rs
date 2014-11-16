struct Point {
    x: int,
    y: int,
}

fn main() {
	let x: int;
	x = 5i;
    println!("Hello, world! x: {}", x);

    let origin = Point { x: 0i, y: 0i };
    println!("The origin is at ({}, {})", origin.x, origin.y);

}