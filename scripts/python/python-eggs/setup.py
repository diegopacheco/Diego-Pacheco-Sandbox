from setuptools import setup

setup(
    name='simpleeggs',
    version='1.0.0',
    packages=['simpleeggs'],
    url='https://github.com/diegopacheco',
    license='BSD License',
    author='diegopacheco',
    author_email='diego.pacheco.it@gmail.com',
    description='A simple python eggs',
    include_package_data=True,
    install_requires=["requests"],
    entry_points={
    },
    classifiers=[
        "License :: OSI Approved :: BSD License"
    ]
)
