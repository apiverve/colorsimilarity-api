from setuptools import setup, find_packages

setup(
    name='apiverve_colorsimilaritycalculator',
    version='1.1.14',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Color Similarity Calculator is a tool for calculating similarity between two colors. It uses multiple algorithms including RGB distance, HSL comparison, and Delta E to provide comprehensive color similarity analysis.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/colorsimilarity?utm_source=pypi&utm_medium=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
