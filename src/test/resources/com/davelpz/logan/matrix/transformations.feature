Feature: Matrix Transformations

Scenario: Multiplying by a translation matrix
  Given mtransform ← translation(5, -3, 2)
    And mp ← point(-3, 4, 5)
   Then mtransform * mp = point(2, 1, 7)

Scenario: Multiplying by the inverse of a translation matrix
  Given mtransform ← translation(5, -3, 2)
    And inv ← inverse(mtransform)
    And mp ← point(-3, 4, 5)
   Then inv * mp = point(-8, 7, 3)

Scenario: Translation does not affect vectors
  Given mtransform ← translation(5, -3, 2)
    And mv ← vector(-3, 4, 5)
   Then mtransform * mv = mv

Scenario: A scaling matrix applied to a point
  Given mtransform ← scaling(2, 3, 4)
    And mp ← point(-4, 6, 8)
   Then mtransform mul mp = point(-8, 18, 32)

Scenario: A scaling matrix applied to a vector
  Given mtransform ← scaling(2, 3, 4)
    And mv ← vector(-4, 6, 8)
   Then mtransform * mv = vector(-8, 18, 32)

Scenario: Multiplying by the inverse of a scaling matrix
  Given mtransform ← scaling(2, 3, 4)
    And inv ← inverse(mtransform)
    And mv ← vector(-4, 6, 8)
   Then inv * mv = vector(-2, 2, 2)

Scenario: Reflection is scaling by a negative value
  Given mtransform ← scaling(-1, 1, 1)
    And mp ← point(2, 3, 4)
   Then mtransform mul mp = point(-2, 3, 4)

Scenario: Rotating a point around the x axis
  Given mp ← point(0, 1, 0)
    And half_quarter ← rotation_x(π / 4)
    And full_quarter ← rotation_x(π / 2)
  Then half_quarter * mp = point(0, 0.70710678118, 0.70710678118)
    And full_quarter mul mp = point(0, 0, 1)

Scenario: The inverse of an x-rotation rotates in the opposite direction
  Given mp ← point(0, 1, 0)
    And half_quarter ← rotation_x(π / 4)
    And inv ← inverse(half_quarter)
  Then inv mul mp = point(0, 0.70710678118, -0.70710678118)

Scenario: Rotating a point around the y axis
  Given mp ← point(0, 0, 1)
    And half_quarter ← rotation_y(π / 4)
    And full_quarter ← rotation_y(π / 2)
  Then half_quarter mul mp = point(0.70710678118, 0.0, 0.70710678118)
    And full_quarter mul mp = point(1.0, 0.0, 0.0)

Scenario: Rotating a point around the z axis
  Given mp ← point(0, 1, 0)
    And half_quarter ← rotation_z(π / 4)
    And full_quarter ← rotation_z(π / 2)
  Then half_quarter mul mp = point(-0.70710678118, 0.70710678118, 0.0)
    And full_quarter mul mp = point(-1.0, 0.0, 0.0)

Scenario: A shearing transformation moves x in proportion to y
  Given mtransform ← shearing(1, 0, 0, 0, 0, 0)
    And mp ← point(2, 3, 4)
  Then mtransform mul mp = point(5, 3, 4)

Scenario: A shearing transformation moves x in proportion to z
  Given mtransform ← shearing(0, 1, 0, 0, 0, 0)
    And mp ← point(2, 3, 4)
  Then mtransform mul mp = point(6, 3, 4)

Scenario: A shearing transformation moves y in proportion to x
  Given mtransform ← shearing(0, 0, 1, 0, 0, 0)
    And mp ← point(2, 3, 4)
  Then mtransform mul mp = point(2, 5, 4)

Scenario: A shearing transformation moves y in proportion to z
  Given mtransform ← shearing(0, 0, 0, 1, 0, 0)
    And mp ← point(2, 3, 4)
  Then mtransform mul mp = point(2, 7, 4)

Scenario: A shearing transformation moves z in proportion to x
  Given mtransform ← shearing(0, 0, 0, 0, 1, 0)
    And mp ← point(2, 3, 4)
  Then mtransform mul mp = point(2, 3, 6)

Scenario: A shearing transformation moves z in proportion to y
  Given mtransform ← shearing(0, 0, 0, 0, 0, 1)
    And mp ← point(2, 3, 4)
  Then mtransform mul mp = point(2, 3, 7)

Scenario: Individual transformations are applied in sequence
  Given mp ← point(1, 0, 1)
    And A ← rotation_x(π / 2)
    And B ← scaling(5, 5, 5)
    And C ← translation(10, 5, 7)
  # apply rotation first
  When p2 ← A * mp
  Then p2 = point(1, -1, 0)
  # then apply scaling
  When p3 ← B * p2
  Then p3 = point(5, -5, 0)
  # then apply translation
  When p4 ← C * p3
  Then p4 = point(15, 0, 7)

Scenario: Chained transformations must be applied in reverse order
  Given mp ← point(1, 0, 1)
    And A ← rotation_x(π / 2)
    And B ← scaling(5, 5, 5)
    And C ← translation(10, 5, 7)
  When T ← C * B * A
  Then T * mp = point(15, 0, 7)

#Scenario: The transformation matrix for the default orientation
#  Given from ← point(0, 0, 0)
#    And to ← point(0, 0, -1)
#    And up ← vector(0, 1, 0)
#  When t ← view_transform(from, to, up)
#  Then t = identity_matrix
#
#Scenario: A view transformation matrix looking in positive z direction
#  Given from ← point(0, 0, 0)
#    And to ← point(0, 0, 1)
#    And up ← vector(0, 1, 0)
#  When t ← view_transform(from, to, up)
#  Then t = scaling(-1, 1, -1)
#
#Scenario: The view transformation moves the world
#  Given from ← point(0, 0, 8)
#    And to ← point(0, 0, 0)
#    And up ← vector(0, 1, 0)
#  When t ← view_transform(from, to, up)
#  Then t = translation(0, 0, -8)
#
#Scenario: An arbitrary view transformation
#  Given from ← point(1, 3, 2)
#    And to ← point(4, -2, 8)
#    And up ← vector(1, 1, 0)
#  When t ← view_transform(from, to, up)
#  Then t is the following 4x4 matrix:
#      | -0.50709 | 0.50709 |  0.67612 | -2.36643 |
#      |  0.76772 | 0.60609 |  0.12122 | -2.82843 |
#      | -0.35857 | 0.59761 | -0.71714 |  0.00000 |
#      |  0.00000 | 0.00000 |  0.00000 |  1.00000 |
