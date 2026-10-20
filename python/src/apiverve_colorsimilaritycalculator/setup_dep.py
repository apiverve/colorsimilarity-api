from setuptools import setup, find_packages

setup(
    name='apiverve_colorsimilaritycalculator',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Color Similarity Calculator measures color similarity between two hex values. It returns an overall similarity score, a categorical match rating, and RGB and HSL channel breakdowns, while paid plans add Delta E and color distance metrics.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/colorsimilarity?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
