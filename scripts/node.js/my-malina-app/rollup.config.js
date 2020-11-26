import resolve from '@rollup/plugin-node-resolve';
import derver from 'derver/rollup-plugin';
import malina from 'malinajs/malina-rollup'

const DEV = !!process.env.ROLLUP_WATCH;

export default {
    input: 'src/main.js',
    output: {
        file: 'public/bundle.js',
        format: 'iife',
    },
    plugins: [
        malina({
            hideLabel: !DEV,
        }),
        resolve(),
        DEV && derver()
    ],
    watch: {
        clearScreen: false
    }
}